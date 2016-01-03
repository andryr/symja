/**
This file is part of a jTEM project.
All jTEM projects are licensed under the FreeBSD license 
or 2-clause BSD license (see http://www.opensource.org/licenses/bsd-license.php). 

Copyright (c) 2002-2009, Technische Universität Berlin, jTEM
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

-	Redistributions of source code must retain the above copyright notice, 
	this list of conditions and the following disclaimer.

-	Redistributions in binary form must reproduce the above copyright notice, 
	this list of conditions and the following disclaimer in the documentation 
	and/or other materials provided with the distribution.
 
THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS 
BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, 
OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT 
OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING 
IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY 
OF SUCH DAMAGE.
**/

package de.jtem.mfc.field;

import javax.swing.BoundedRangeModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

/**
 * An implementation of BoundedRangeModel providing the storage of double
 * values.
 */
public class DoubleBoundedRangeModel implements BoundedRangeModel
{
  private double min, max, value;
  private double divider;
  private boolean isAdjusting;

  /**
   * Constructs a new DoubleBoundedRangeModel with a default minimum of -1.0
   * and maximum of 1.0.
   */
  public DoubleBoundedRangeModel()
  {
    min=-1.;
    max=1.;
    updateRange();
  }
  public void setDoubleMinimum(double min)
  {
    if(this.min==min)
      return;
    else if(min>this.min)
    {
      if(min>max)
        max=min;
      if(min>value)
        value=min;
    }
    this.min=min;

    updateRange();

    fireChangeEvent();
  }
  public double getDoubleMinimum()
  {
    return min;
  }
  public void setDoubleMaximum(double max)
  {
    if(this.max==max)
      return;
    if(max<this.max)
    {
      if(max<min)
        min=max;
      if(max<value)
        value=max;
    }
    this.max=max;

    updateRange();

    fireChangeEvent();
  }
  public double getDoubleMaximum()
  {
    return max;
  }
  public void setDoubleValue(double newValue)
  {
    if(value==newValue) return;
    value=newValue;
    boolean rangeChanged=false;
    if(value<min)
    {
      min=value;
      rangeChanged=true;
    }
    else if(value>max)
    {
      max=value;
      rangeChanged=true;
    }
    else if(!isAdjusting)
    {
      if(value==min)
      {
        min=relativeMin(value);
        rangeChanged=true;
      }
      else if(value==max)
      {
        max=relativeMax(value);
        rangeChanged=true;
      }
    }
    if(rangeChanged) updateRange();
    fireChangeEvent();
  }
  public double getDoubleValue()
  {
    return value;
  }
  private void updateRange()
  {
    divider=(max-min)/Integer.MAX_VALUE;
  }
  /** 
   * Returns the largest decimal power that is still less than the argument.
   */
  public static double relativeMin(double value)
  {
    if(value==0)
      return -1;
    double digits=Math.ceil(Math.log(Math.abs(value))/Math.log(10));
    if(value<0)
    {
      if(value>-1)
	return -1;
      if(value==-Math.pow(10., digits))
	return -Math.pow(10., digits+1);
      return -Math.pow(10., digits);
    }
    else
    {
      if(value<=1)
	return 0;
      return Math.pow(10., digits-1);
    }
  }
  /** 
   * Returns the smallest decimal power that is still greater than the
   * argument.
   */
  public static double relativeMax(double value)
  {
    if(value==0)
      return 1;
    double digits=Math.ceil(Math.log(Math.abs(value))/Math.log(10));
    if(value<0)
    {
      if(value>=-1)
	return 0;
      return -Math.pow(10., digits-1);
    }
    else
    {
      if(value<1)
        return 1;
      if(value==Math.pow(10., digits))
        return Math.pow(10., digits+1);
      return Math.pow(10., digits);
    }
  }

  /** @return <code>1</code> */
  public int getExtent()
  {
    return 1;
  }
  /**
   * Returns the biggest integer value representing every possible double
   * maximum as an integer.
   * 
   * @return <code>Integer.MAX_VALUE</code>
   */
  public int getMaximum()
  {
    return Integer.MAX_VALUE;
  }
  /**
   * Returns the integer value 0 representing every possible double minimum
   * as an integer.
   * 
   * @return <code>0</code>
   */  
  public int getMinimum()
  {
    return 0;
  }
  /**
   * Returns the relativ int value of the current double value. 
   */
  public int getValue()
  {
    return (int)((value-min)/divider);
  }
  public boolean getValueIsAdjusting()
  {
    return isAdjusting;
  }
  /**
   * An empty method, because getExtend() returns a constant value.
   */
  public void setExtent(int newExtent) {}
  /**
   * An empty method, because getMaximum() returns a constant value.
   */
  public void setMaximum(int newMaximum) {}
  /**
   * An empty method, because getMinimum() returns a constant value.
   */
  public void setMinimum(int newMinimum) {}
  /**
   * Calculates the double value, the specified int value is representing.
   */
  public void setValue(int newValue)
  {
    setDoubleValue(newValue*divider+min);
  }
  public void setValueIsAdjusting(boolean b)
  {
    boolean fireLater=false;
    if(b!=isAdjusting)
    {
      isAdjusting=b;
      if(!isAdjusting)
      {
	if(value==min)
	{
	  min=relativeMin(value);
	  fireLater=true;
	}
	else if(value==max)
	{
	  fireLater=true;
	  max=relativeMax(value);
	}
	if(fireLater) updateRange();
      }
    }
    // required for JSlider (at least in JDK1.3.1)
    if(fireLater) SwingUtilities.invokeLater(new Runnable()
    {
      public void run()
      {
        fireChangeEvent();
      }
    });
    else fireChangeEvent();
  }
  public void setRangeProperties(int newValue, int extent, int min, int max,
    boolean adjusting)
  {
    boolean valueChanged=(value!=newValue);
    boolean adjustingChanged=(isAdjusting!=adjusting);
    value=newValue;
    isAdjusting=adjusting;
    if(valueChanged||adjustingChanged)
      fireChangeEvent();
  }
  //---------------------------------------------------------------------------
  EventListenerList listenerList = new EventListenerList();
  ChangeEvent changeEvent = null;
  public void addChangeListener(ChangeListener l)
  {
    listenerList.add(ChangeListener.class, l);
  }
  public void removeChangeListener(ChangeListener l)
  {
    listenerList.remove(ChangeListener.class, l);
  }
  public void fireChangeEvent()
  {
    Object[] listeners = listenerList.getListenerList();
    for (int i = listeners.length-2; i>=0; i-=2)
      if(listeners[i]==ChangeListener.class)//in diesem Fall immer so!
      {
        if(changeEvent == null)
          changeEvent=new ChangeEvent(this);
        ((ChangeListener)listeners[i+1]).stateChanged(changeEvent);
      }
  }
}
