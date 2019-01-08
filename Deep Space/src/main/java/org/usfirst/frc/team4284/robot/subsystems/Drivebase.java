/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4284.robot.subsystems;

// CTRE imports for Talons
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;


// Import other code files
import org.usfirst.frc.team4284.robot.Robot;
import org.usfirst.frc.team4284.robot.RobotMap;
import org.usfirst.frc.team4284.robot.commands.MecDrive;

// Wpilibj import stuff
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;


public class Drivebase extends Subsystem {

  // Talons for drivebase
  private TalonSRX leftFrontMotor;
  private TalonSRX leftBackMotor;
  private TalonSRX rightFrontMotor;
  private TalonSRX rightBackMotor;

  // Setup for drivebase var
  RobotDrive myDrive;
  
  // Just to shorten code for setting up RobotDrive, not useful otherwise
	private final int kFrontLeftChannel = RobotMap.LEFTFRONT_MOTOR.value;
	private final int kRearLeftChannel = RobotMap.LEFTBACK_MOTOR.value;
	private final int kFrontRightChannel = RobotMap.RIGHTFRONT_MOTOR.value;
  private final int kRearRightChannel = RobotMap.RIGHTBACK_MOTOR.value;

  public Drivebase(){

    // Sets up Talons w/ IDs
    leftFrontMotor = new TalonSRX(RobotMap.LEFTFRONT_MOTOR.value);
    leftBackMotor = new TalonSRX(RobotMap.LEFTBACK_MOTOR.value);
    rightFrontMotor = new TalonSRX(RobotMap.RIGHTFRONT_MOTOR.value);
    rightBackMotor = new TalonSRX(RobotMap.RIGHTBACK_MOTOR.value);

    //Init talons w/ func in robot
    Robot.initTalon(leftFrontMotor);
    Robot.initTalon(leftBackMotor);
    Robot.initTalon(rightFrontMotor);
    Robot.initTalon(rightBackMotor);

    // Put in vals as motor ports for top left, bottom left, top right, bottom right, in that order
    myDrive = new RobotDrive(kFrontLeftChannel, kRearLeftChannel, kFrontRightChannel, kRearRightChannel);

    // Invert vals for these motors to make sure wheels function together properly
		myDrive.setInvertedMotor(MotorType.kFrontLeft, true);
    myDrive.setInvertedMotor(MotorType.kRearLeft, true);
    
    // Expiration time on safety, don't worry about it too much
		myDrive.setExpiration(0.1);

  }

  // Set wheels speed and direction
  public void setMecanumDrive(double x, double y, double z){
    // Sets motor safety (if it wasn't obvious)
    myDrive.setSafetyEnabled(true);

    // Sets mecanum drive vals
      myDrive.mecanumDrive_Cartesian(x, y, z, 0);
      
      // Not really sure what it is used for, but was recommended by another team
			Timer.delay(0.05);
  }


  @Override
  public void initDefaultCommand() {

    // The syntax for this is below for future teams using command based model
    setDefaultCommand(new MecDrive());
  }
}
