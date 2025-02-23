package frc.robot.commands;

import java.util.function.Supplier;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ArmPivotSubsystem;

public class ArmPivotPIDCmd extends Command {

  private final ArmPivotSubsystem armPivotSubsystem;
  private final Supplier<Double> speedFunction;
  //private final Joystick joyArm = new Joystick(Constants.OIConstants.kArmJoystickPort);

  double realTimeSpeed = 0;

  public ArmPivotPIDCmd(ArmPivotSubsystem armPivotSubsystem, Supplier<Double> speedFunction) {
    this.armPivotSubsystem = armPivotSubsystem;
    this.speedFunction = speedFunction;
    addRequirements(armPivotSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    realTimeSpeed = speedFunction.get() * Constants.ArmPivotConstants.kArmPivotSpeedPercentageThrottled;
    armPivotSubsystem.setMotor(realTimeSpeed);
    System.out.println("realTimeSpeed = " + realTimeSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armPivotSubsystem.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /*
    if (Math.abs(joyArm.getRawAxis(Constants.OIConstants.kArmPivotAxis)) > 0.05) {
      return true;
    } else {
      return false;
    }
    */

    return false;
  }
}
