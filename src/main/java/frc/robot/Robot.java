/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.networktables.NetworkTable;
//import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.command.Scheduler;
//import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.PID_Drive;
/*import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;*/
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends TimedRobot {
  public static DriveTrain driveTrain;
  public static OI m_oi;
  public static Joystick m_stick;
  public RobotMap map;
  //public ArcadeDrive m_ADrive;
  //private final DifferentialDrive m_robotDrive = new DifferentialDrive(Left, Right);
  //private final Timer m_timer = new Timer();
  public PID_Drive piddrive = new PID_Drive(1, 1, 1);
  NetworkTable table;

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    //m_oi = new OI();
    driveTrain = new DriveTrain();
    m_stick = new Joystick(RobotMap.m_stick);
    //m_ADrive = new ArcadeDrive();

    
    //NetworkTableInstance inst = NetworkTableInstance.getDefault();
    //table = inst.getTable("ChickenVision");
    //table = inst.getTable("Joystick");
  }

  @Override
  public void robotPeriodic() {
   // super.robotPeriodic();
  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {
    //Scheduler.getInstance().run();
  }

  /**
   * This function is run once each time the robot enters autonomous mode.
   */
  @Override
  public void autonomousInit() {
    //m_timer.reset();
    //m_timer.start();

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    //Scheduler.getInstance().run(); 
    // Drive for 2 seconds
    
  }
  
  /**
   * This function is called once each time the robot enters teleoperated mode.
   */
  @Override
  public void teleopInit() {
    //m_timer.reset();
    //m_timer.start();

  }

  /**
   * This function is called periodically during teleoperated mode.
   * 
   * return
   */
  //double x_value;

  public double constrain(double num) {
    if (num > 1) {
      num = 1; 
    }
    else if (num < -1) {
      num = -1;
    }
    return num;
  }
  public double getAngle(double x, double y){
    return Math.atan(x/y)/Math.PI;
  }
  @Override
  public void teleopPeriodic() {
    //Scheduler.getInstance().run();
    //piddrive.setSetpoint(getAngle(m_stick.getX(),m_stick.getY()));
    DriveTrain.m_drive.arcadeDrive(m_stick.getY()-0.1,constrain(getAngle(m_stick.getX(),m_stick.getY())));
    //piddrive.execute(m_stick.getY()-0.1);
    /*
    if (m_stick.getX() < 0.1 && m_stick.getX() > -0.1) {
      x_value = 0;
    } else {
      x_value = m_stick.getX();
    }
    */
    //m_ADrive.execute();
    //m_robotDrive.arcadeDrive(m_stick.getY(), x_value);
    //front_Left.set(ControlMode.PercentOutput, m_stick.getX());
    //back_Left.set(ControlMode.PercentOutput, m_stick.getY()+0.1);
  }
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
