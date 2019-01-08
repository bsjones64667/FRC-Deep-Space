/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4284.robot;

// Control import
import edu.wpi.first.wpilibj.Joystick;

public class OI {
	// Distance pushed for it to register properly
	public static final double JOY_DEADZONE = 0.05;
	public final Joystick DRIVE_JOY = new Joystick(RobotMap.DRIVE_JOY.value);

	public OI() {

	}

	// Checks to make sure joy pushed far enough, call these methods to get inputs for axes
	public double getDriveJoyX() {
		double raw = DRIVE_JOY.getX();
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getDriveJoyY() {
		double raw = DRIVE_JOY.getY();
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}

	public double getDriveJoyZ(){
		double raw = DRIVE_JOY.getZ();
		return Math.abs(raw) < JOY_DEADZONE ? 0.0 : raw;
	}
}
