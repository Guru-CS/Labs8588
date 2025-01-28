// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class Dumpster extends SubsystemBase {
  
  public static final int dumpsterMotorNumber = 21;
  private CANSparkMax m_dumpsterDown;

  /** Creates a new ExampleSubsystem. */
  public Dumpster() {
    m_dumpsterDown =  new CANSparkMax(dumpsterMotorNumber, MotorType.kBrushless);

  }
  /**
   * Example command factory method.
   *
   * @return a command
   */
  public void releaseCoral(double speed) {

    m_dumpsterDown.set(speed);
  }


  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}