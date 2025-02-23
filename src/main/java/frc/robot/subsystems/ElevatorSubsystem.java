package frc.robot.subsystems;

//import java.util.Set;

//import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
//import com.ctre.phoenix.motorcontrol.InvertType;
//import com.ctre.phoenix.motorcontrol.NeutralMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {

    private final SparkMax elevatorMotor = new SparkMax(Constants.ElevatorConstants.kElevatorMotorPort, MotorType.kBrushless);
    private final RelativeEncoder elevatorEncoder = elevatorMotor.getEncoder();


    public double getEncoderMeters() {
        return (((RelativeEncoder) elevatorEncoder).getPosition());
      }

    public ElevatorSubsystem () {
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("ElevatorEncoder Value",  getEncoderMeters());
    }

    public void setMotor(double speed) {
        //armPivotMotorFollow.follow(armPivotMotorLead);
        SmartDashboard.putNumber("pivot speed", speed);
        elevatorMotor.set(speed);
    }

}