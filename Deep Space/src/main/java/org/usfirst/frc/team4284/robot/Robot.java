/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4284.robot;

// Import commands and subysystems
import org.usfirst.frc.team4284.robot.subsystems.*;
import org.usfirst.frc.team4284.robot.commands.*;

//Import wpilibj resources needed
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

// Talon Imports
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Robot extends TimedRobot {

	// Subsystem objects
	public static OI oi;
	public static Drivebase drivebase;



	@Override
	public void robotInit() {
		oi = new OI();
		drivebase = new Drivebase();


	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {

	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

	}

	@Override
	public void teleopPeriodic() {
		
		
	}

	@Override
	public void testPeriodic() {
	}

	// Method to init talons and give certain params
	public static void initTalon(TalonSRX motor){

		// Do not force stop motor, let it run down and stop
		motor.setNeutralMode(NeutralMode.Coast);

		// Sets control mode to disabled
		motor.neutralOutput();

		// Sets the sensor phase, make sure that when motor is positive, encoder is also positive. If that is not the case, flip the value
		motor.setSensorPhase(false);

		// Configs a limit switch for the motor, forwards and reverse
		motor.configForwardLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);
		motor.configReverseLimitSwitchSource(LimitSwitchSource.FeedbackConnector, LimitSwitchNormal.NormallyOpen, 0);

		// Configs motor power percentages and ms timeout
		motor.configNominalOutputForward(0.0, 0);
		motor.configNominalOutputReverse(0.0, 0);

		// Configs closed loop ramp speed
		motor.configClosedloopRamp(0.5, 0);


	}
}
