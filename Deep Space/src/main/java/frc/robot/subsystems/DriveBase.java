package frc.robot.subsystems;

import frc.robot.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveBase extends Subsystem {

	private Spark leftMotor;
	private Spark rightMotor;

	public DriveBase() {
		leftMotor = new Spark(RobotMap.LEFT_MOTOR.value);
		rightMotor = new Spark(RobotMap.RIGHT_MOTOR.value);
	}

	public void setRaw(double leftValue, double rightValue) {
		leftMotor.set(leftValue);
		rightMotor.set(rightValue);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive());

	}

}
