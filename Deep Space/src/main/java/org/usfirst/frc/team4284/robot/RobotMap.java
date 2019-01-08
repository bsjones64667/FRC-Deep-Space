/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4284.robot;

// Enum RobotMap is used to store vals for ports
public enum RobotMap {
	// Talon SRX Motor Mappings
	LEFTFRONT_MOTOR(0),
	LEFTBACK_MOTOR(1), 
	RIGHTFRONT_MOTOR(2),
	RIGHTBACK_MOTOR(3),
	// Control Mappings
	DRIVE_JOY(0);

	public final int value;

	RobotMap(int value) {
		this.value = value;
	}
}
