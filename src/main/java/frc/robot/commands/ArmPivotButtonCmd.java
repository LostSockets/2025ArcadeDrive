package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ArmPivotSubsystem;

public class ArmPivotButtonCmd extends Command {

  private final ArmPivotSubsystem armPivotSubsystem;
  private final double speed;

  public ArmPivotButtonCmd(ArmPivotSubsystem armPivotSubsystem, double speed) {
    this.armPivotSubsystem = armPivotSubsystem;
    this.speed = speed;
    addRequirements(armPivotSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    armPivotSubsystem.setMotor(speed);
    //System.out.println("speed" + speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armPivotSubsystem.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return false;
  }
}
