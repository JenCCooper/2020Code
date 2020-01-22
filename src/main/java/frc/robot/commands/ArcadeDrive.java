/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.JoystickController;
import frc.robot.subsystems.DriveTrain;

public class ArcadeDrive extends Command {
  public ArcadeDrive() {
    // Use requires() here to declare subsystem dependencies
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    DriveTrain.front_Left.set(ControlMode.PercentOutput, constrain(JoystickController.Y_Value + JoystickController.X_Value));
    DriveTrain.back_Left.set(ControlMode.PercentOutput, constrain(JoystickController.Y_Value + JoystickController.X_Value));
    DriveTrain.front_Right.set(ControlMode.PercentOutput, constrain(JoystickController.Y_Value - JoystickController.X_Value));
    DriveTrain.back_Right.set(ControlMode.PercentOutput, -1*constrain(JoystickController.Y_Value - JoystickController.X_Value));
   
  }

  private double constrain(double num) {
    if (num > 1) {
      num = 1; 
    }
    else if (num < -1) {
      num = -1;
    }
    return num;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    DriveTrain.front_Left.set(ControlMode.PercentOutput, 0);
    DriveTrain.back_Left.set(ControlMode.PercentOutput, 0);
    DriveTrain.front_Right.set(ControlMode.PercentOutput, 0);
    DriveTrain.back_Right.set(ControlMode.PercentOutput, 0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
