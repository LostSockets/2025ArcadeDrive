
package frc.robot.commands;

import java.util.function.Supplier;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ArmPivotSubsystem;

public class ArmPivotJoyCmd extends Command {
    private final ArmPivotSubsystem armPivotSubsystem;
    private final Supplier<Double> speedFunction;

    double realTimeSpeed = 0;

   
    public ArmPivotJoyCmd(ArmPivotSubsystem armPivotSubsystem, Supplier<Double> speedFunction) {
        this.armPivotSubsystem = armPivotSubsystem;
        this.speedFunction = speedFunction;
        addRequirements(armPivotSubsystem);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    realTimeSpeed = speedFunction.get() * Constants.ArmPivotConstants.kArmPivotSpeedPercentage;
    armPivotSubsystem.setMotor(-realTimeSpeed);
    
    //System.out.println("speed = " + realTimeSpeed);
    //System.out.println("encoder = " + armPivotSubsystem.getEncoderMeters());
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
