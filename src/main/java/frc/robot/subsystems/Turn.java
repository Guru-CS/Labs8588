// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.SwerveSubsystem;



public class Turn extends SubsystemBase {
  // create a variable
  public double turnSpeed;

  /** CONSTRUCTOR: this runs once when the object is created */
  public Turn() {
    // initalize the variable
    turnSpeed = 0;
  }

  // set the turnSpeed to a positive number
  public void spin(double degreesPerSecond) {
    // set our variable
    /* This is a MAGIC NUMBER. These are normally bad in coding, but in robotics often we have to use these because of the way motors are set up
     * a speed of 0.088 will equate to 180 degrees turned -- a thousandth of the degrees, divided by two and subtracted by 2
     */
    turnSpeed = 0.001*((degreesPerSecond/2)-2);
    //if we wanted to do the turning in this subsystem: driveSubsystem.drive(new ChassisSpeeds(0, 0, Math.PI/slowness));
  }

  // zero out the turn speed
  public void stopSpinning() {
    System.out.println("stopping!");
    turnSpeed = 0;
  }
}