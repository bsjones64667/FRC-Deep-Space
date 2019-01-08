/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4284.robot.commands;

import org.usfirst.frc.team4284.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MecDrive extends Command {
  public MecDrive() {
    requires(Robot.drivebase);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    // Get axis vals and set constantly for drive
    Robot.drivebase.setMecanumDrive(Robot.oi.getDriveJoyX(), Robot.oi.getDriveJoyY(), Robot.oi.getDriveJoyZ());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
