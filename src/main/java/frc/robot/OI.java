package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This handles all of the joystick signals, And getting all of the raw values
 */
public class OI {

    private Joystick driverController = new Joystick(RobotMap.driverController);

    public double GetDriverRawAxis(int axis){
        return driverController.getRawAxis(axis);
    }
}