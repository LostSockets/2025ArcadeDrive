package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ArcadeDriveCmd extends Command {

  private final DriveSubsystem driveSubsystem;
  private final Supplier<Double> speedFunction, turnFunction;
  private final Joystick joyDrive = new Joystick(Constants.OIConstants.kDriverJoystickPort);

  boolean turbo = false;
  double realTimeSpeed = 0;
  double realTimeTurn = 0;

  public ArcadeDriveCmd(DriveSubsystem driveSubsystem, Supplier<Double> speedFunction, Supplier<Double> turnFunction) {
    this.speedFunction = speedFunction;
    this.turnFunction = turnFunction;
    this.driveSubsystem = driveSubsystem;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize(
    
  ) {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if (joyDrive.getRawButton(Constants.OIConstants.kArcadeDriveTurbo)) {
      realTimeSpeed = speedFunction.get() * Constants.DriveConstants.speedTurbo;
      realTimeTurn = turnFunction.get() * Constants.DriveConstants.turnTurbo;      
    } else if(joyDrive.getRawButton(Constants.OIConstants.kArcadeDriveMellow))  {
      realTimeSpeed = speedFunction.get() * Constants.DriveConstants.speedThrottle;
      realTimeTurn = turnFunction.get() * Constants.DriveConstants.turnMellow;    
    } else {
      realTimeSpeed = speedFunction.get() * Constants.DriveConstants.speedThrottle;
      realTimeTurn = turnFunction.get() * Constants.DriveConstants.turnThrottle;
    }
    
    if (Math.abs(realTimeSpeed) < 0.05) {
      realTimeSpeed = 0;
    }
    if (Math.abs(realTimeTurn) < 0.05) {
      realTimeTurn = 0;
    }
    
    double left = 0;
    double right = 0;

    if (joyDrive.getRawAxis(2) > 0.5) {
      if (realTimeSpeed <= -0.01) {
        left = realTimeSpeed - realTimeTurn;
        right = realTimeSpeed + realTimeTurn;
      } else {
        left = realTimeSpeed + realTimeTurn;
        right = realTimeSpeed - realTimeTurn;
      }
      driveSubsystem.setMotors(-left, -right);
    } else {
      if (realTimeSpeed <= -0.01) {
        left = realTimeSpeed + realTimeTurn;
        right = realTimeSpeed - realTimeTurn;
      } else {
        left = realTimeSpeed - realTimeTurn;
        right = realTimeSpeed + realTimeTurn;
      }
      driveSubsystem.setMotors(left, right);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
