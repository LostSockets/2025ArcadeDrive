package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;

public class AutoDelay extends Command {

private final double timeDelay;
private double startTime = 0;

  public AutoDelay(double timeDelay) {
    this.timeDelay = timeDelay;
}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Timer timer = new Timer();
    startTime = Timer.getFPGATimestamp();
    System.out.println("AutoDelay started");
    System.out.print("startTime");
    System.out.println(startTime);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.print("Current time = ");
    System.out.println(Timer.getFPGATimestamp());
    System.out.print("Time remaining = ");
    System.out.println(Timer.getFPGATimestamp() - startTime);    
    while (Timer.getFPGATimestamp() - startTime < timeDelay){
      // This is just a delay timer!
      System.out.print("Time remaining = ");
      System.out.println(Timer.getFPGATimestamp() - startTime);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    System.out.println("AutoDelay ended");
    return true;
 }
}
