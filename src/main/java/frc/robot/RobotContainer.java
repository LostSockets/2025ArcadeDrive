// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//Constants
//import frc.robot.Constants.DriveConstants;
//import frc.robot.Constants.OIConstants;
//import frc.robot.Constants.ArmTelescopicConstants;

//Commands
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.ArcadeDrivePIDHoldInPlaceCmd;
import frc.robot.commands.ArmPivotButtonPIDCmd;
import frc.robot.commands.ArmPivotJoyCmd;
import frc.robot.commands.AutoDelay;
import frc.robot.commands.AutoDriveBkwdCmd;
import frc.robot.commands.AutoDriveFwdCmd;
//import frc.robot.commands.ArmPivotButtonCmd;
import frc.robot.commands.AutoPivot;


//Subsystems
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ArmPivotSubsystem;


//Libraries
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  //private final ArmTelescopicSubsystem armTelescopicSubsystem = new ArmTelescopicSubsystem();
  //private final ArmPivotSubsystem armPivotSubsystem = new ArmPivotSubsystem();

  private final Joystick joyDrive = new Joystick(Constants.OIConstants.kDriverJoystickPort);
  //private final Joystick joyArm = new Joystick(Constants.OIConstants.kArmJoystickPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    //Default commands
    driveSubsystem.setDefaultCommand(new ArcadeDriveCmd(driveSubsystem, () -> -joyDrive.getRawAxis(Constants.OIConstants.kArcadeDriveSpeedAxis), () -> -joyDrive.getRawAxis(Constants.OIConstants.kArcadeDriveTurnAxis)));
    configureBindings();
    //armPivotSubsystem.setDefaultCommand(new ArmPivotCmd(armPivotSubsystem, () -> -joyArm.getRawAxis(Constants.OIConstants.kArmPivotAxis)));
    //armPivotSubsystem.setDefaultCommand(new ArmPivotCmd(armPivotSubsystem, 0));
  }

  private void configureBindings() {
    //new JoystickButton(joyArm, Constants.OIConstants.kArmPivotPIDPos0Button).onTrue(new ArmPivotButtonPIDCmd(armPivotSubsystem, Constants.ArmPivotConstants.kArmPivotPos0));
    //new JoystickButton(joyArm, Constants.OIConstants.kArmPivotPIDPos1Button).onTrue(new ArmPivotButtonPIDCmd(armPivotSubsystem, Constants.ArmPivotConstants.kArmPivotPos1));
    //new JoystickButton(joyArm, Constants.OIConstants.kArmPivotPIDPos2Button).onTrue(new ArmPivotButtonPIDCmd(armPivotSubsystem, Constants.ArmPivotConstants.kArmPivotPos2));
    //new JoystickButton(joyArm, Constants.OIConstants.kArmPivotPIDPos3Button).onTrue(new ArmPivotButtonPIDCmd(armPivotSubsystem, Constants.ArmPivotConstants.kArmPivotPos3));
    //armPivotSubsystem.setDefaultCommand(new ArmPivotJoyCmd(armPivotSubsystem, () -> -joyArm.getRawAxis(Constants.OIConstants.kArmPivotAxis)));
    //new JoystickButton(joyArm, Constants.OIConstants.kArmPivotDown).whileTrue(new ArmPivotButtonCmd(armPivotSubsystem, Constants.ArmPivotConstants.kArmPivotSpeedPercentageThrottled));
    //new JoystickButton(joyArm, Constants.OIConstants.kArmPivotUp).whileTrue(new ArmPivotButtonCmd(armPivotSubsystem, -1*Constants.ArmPivotConstants.kArmPivotSpeedPercentageThrottled));
    new JoystickButton(joyDrive, Constants.OIConstants.kArcadeDriveHoldInPlace).whileTrue((new ArcadeDrivePIDHoldInPlaceCmd(driveSubsystem)));
  }

  public Command getAutonomousCommand() {

    /*
    //Autonomous 1a: Raise to top position using ParallelCommandGroup 
    return new SequentialCommandGroup(
      new AutoPivot(armPivotSubsystem, Constants.AutoConstants.kAutoPivotHeight1),
      new AutoDriveFwdCmd(driveSubsystem, Constants.AutoConstants.kAutoDriveFwdDistance),
      new AutoPivot(armPivotSubsystem, Constants.AutoConstants.kAutoPivotHeight2),
      new ParallelCommandGroup ( //
        new AutoDriveBkwdCmd(driveSubsystem, Constants.AutoConstants.kAutoDriveBkwdDistance), new SequentialCommandGroup( //
          new AutoDelay(1), new AutoPivot(armPivotSubsystem, Constants.AutoConstants.kAutoPivotHeight3)) //
      )
    */

    /* Autonomous 1b: Raise to top position without using ParallelCommandGroup
    return new SequentialCommandGroup(
      new AutoPivot(armPivotSubsystem, Constants.AutoConstants.kAutoPivotHeight1),
      new AutoDriveFwdCmd(driveSubsystem, Constants.AutoConstants.kAutoDriveFwdDistance),
      new AutoPivot(armPivotSubsystem, Constants.AutoConstants.kAutoPivotHeight2),
      new AutoDriveBkwdCmd(driveSubsystem, Constants.AutoConstants.kAutoDriveBkwdDistance), 
      new AutoPivot(armPivotSubsystem, Constants.AutoConstants.kAutoPivotHeight3) //
    )
    */

    /* Autonomous 2: bump cube back, drive forward 
    return new SequentialCommandGroup(
      new AutoDriveBkwdCmd(driveSubsystem, Constants.AutoConstants.kAuto2DriveBkwdDistance),
      new AutoDriveFwdCmd(driveSubsystem, Constants.AutoConstants.kAuto2DriveFwdDistance)
    )
      */

    /* Autonomous 3: starting arm position resting on back */
    return new SequentialCommandGroup(
      new AutoDriveFwdCmd(driveSubsystem, Constants.AutoConstants.kAutoDriveFwdDistance),
      //new AutoPivot(armPivotSubsystem, Constants.AutoConstants.kAutoPivotHeight2),
      new AutoDriveBkwdCmd(driveSubsystem, Constants.AutoConstants.kAutoDriveBkwdDistance)
      

    
    /*
    //  Autonomous X:  TESTING

    return 
    new SequentialCommandGroup(
      new AutoPivot(armPivotSubsystem, Constants.AutoConstants.kAutoPivotHeight1),
      new ParallelCommandGroup(
        new AutoPivot(armPivotSubsystem, Constants.AutoConstants.kAutoPivotHeight1),
        new AutoDriveFwdCmd(driveSubsystem, 10)
      ),
      new AutoDelay(2),
      new AutoDriveBkwdCmd(driveSubsystem, 2)
    */

    );//
  }
}
