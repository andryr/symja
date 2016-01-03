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

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** 
 * An instance of this class is a JPanel containing one JSlider and 3
 * JTextFields representing the Sliders minimum, maximum and current value.
 *
 * @author	marcel
 */
public class MinMaxPanel extends JPanel
  implements ActionListener, ChangeListener
{
  private JSlider scrol;
  private DoubleBoundedRangeModel minMaxModel;
  private JTextField minTF, maxTF, valTF;
  private double target;

  /** 
   * Creates a MinMaxPanel instance with 1 JSlider, 3 JTextFields and 1 JLabel
   * with the specified name.
   * The JLabel only represents what kind of value is showing by the JSlider
   * (for a better handling with 2 or more MinMaxPanels, e.g.:
   * de.jtem.mfc.field.QuaternionEditor).
   */
  public MinMaxPanel(String name)
  {
    super(new GridBagLayout());
    GridBagConstraints lab=new GridBagConstraints();
    GridBagConstraints gbc=new GridBagConstraints();
    lab.insets.right=2;
    gbc.anchor=GridBagConstraints.NORTHWEST;
    gbc.fill=GridBagConstraints.HORIZONTAL;
    gbc.gridwidth=GridBagConstraints.REMAINDER;
    gbc.weightx=1f;
    add(scrol=new JSlider(minMaxModel=new DoubleBoundedRangeModel()), gbc);
    minMaxModel.addChangeListener(this);
    gbc.insets.top=0;
    lab.gridwidth=1;
    add(new JLabel("min"), lab);
    gbc.gridwidth=2;
    gbc.weightx=0.f;
    add(minTF=new JTextField(), gbc);
    minTF.addActionListener(this);
    minTF.setColumns(4);
    minTF.setHorizontalAlignment(JTextField.LEFT);
    lab.gridwidth=3;
    lab.insets.left=20;
    add(new JLabel(name, JLabel.RIGHT), lab);
    gbc.gridwidth=4;
    gbc.weightx=1f;
    add(valTF=new JTextField(), gbc);
    valTF.addActionListener(this);
    valTF.setColumns(12);
    valTF.setHorizontalAlignment(JTextField.LEFT);
    lab.gridwidth=5;
    add(new JLabel("max"), lab);
    gbc.gridwidth=GridBagConstraints.REMAINDER;
    gbc.weightx=0.f;
    add(maxTF=new JTextField(), gbc);
    maxTF.addActionListener(this);
    maxTF.setColumns(4);
    maxTF.setHorizontalAlignment(JTextField.LEFT);
  }
  public DoubleBoundedRangeModel getModel()
  {
    return minMaxModel;
  }
  public void setMinimum(double min)
  {
    minMaxModel.setDoubleMinimum(min);
  }
  public double getMinimum()
  {
    return minMaxModel.getDoubleMinimum();
  }
  public void setMaximum(double max)
  {
    minMaxModel.setDoubleMaximum(max);
  }
  public double getMaximum()
  {
    return minMaxModel.getDoubleMaximum();
  }
  public void setValue(double val)
  {
    minMaxModel.setDoubleValue(val);
  }
  public double getValue()
  {
    return minMaxModel.getDoubleValue();
  }

  //-------------------------event-handling------------------------------------
  public void actionPerformed(ActionEvent ev)
  {
    final JTextField src=(JTextField)ev.getSource();
    final double v=Double.parseDouble(ev.getActionCommand());
    if     (src==minTF)
      setMinimum(v);
    else if(src==maxTF)
      setMaximum(v);
    else if(src==valTF)
      setValue(v);
  }
  public void stateChanged(ChangeEvent ev)
  {
    double doubleVal=minMaxModel.getDoubleValue();
    double doubleMin=minMaxModel.getDoubleMinimum();
    double doubleMax=minMaxModel.getDoubleMaximum();
    minTF.setText(String.valueOf(doubleMin));
    maxTF.setText(String.valueOf(doubleMax));
    valTF.setText(String.valueOf(doubleVal));
  }
}
