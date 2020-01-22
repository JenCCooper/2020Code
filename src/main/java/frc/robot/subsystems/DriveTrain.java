/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  public static VictorSPX front_Left = new VictorSPX(RobotMap.front_Left_ID);
  public static VictorSPX back_Left = new VictorSPX(RobotMap.back_Left_ID);
  public static VictorSPX front_Right = new VictorSPX(RobotMap.front_Right_ID);
  public static VictorSPX back_Right = new VictorSPX(RobotMap.back_Right_ID);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ArcadeDrive());

  }

}
