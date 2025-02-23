package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class ArcadeDrivePIDHoldInPlaceCmd extends Command {

  private final DriveSubsystem driveSubsystem;
  private double encoderSetpoint;

  public ArcadeDrivePIDHoldInPlaceCmd(DriveSubsystem driveSubsystem) {
    this.driveSubsystem = driveSubsystem;
    addRequirements(driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    encoderSetpoint = driveSubsystem.getEncoderMeters();    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double error = encoderSetpoint - driveSubsystem.getEncoderMeters();
    double outputSpeed = Constants.DriveConstants.kPHoldInPlace * error;

    driveSubsystem.setMotors(-outputSpeed, -outputSpeed);
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
