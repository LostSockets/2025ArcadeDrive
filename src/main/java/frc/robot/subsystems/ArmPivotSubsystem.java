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

public class ArmPivotSubsystem extends SubsystemBase {

    private final SparkMax armPivotMotorLead = new SparkMax(Constants.ArmPivotConstants.kArmPivotMotorPort2, MotorType.kBrushless);
    private final SparkMax armPivotMotorFollow = new SparkMax(Constants.ArmPivotConstants.kArmPivotMotorPort1, MotorType.kBrushed);
    private final RelativeEncoder armPivotEncoder = armPivotMotorLead.getEncoder();


    public double getEncoderMeters() {
        return (((RelativeEncoder) armPivotEncoder).getPosition());
      }

    public ArmPivotSubsystem () {
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("ArmPivotEncoder Value",  getEncoderMeters());
    }

    public void setMotor(double speed) {
        //armPivotMotorFollow.follow(armPivotMotorLead);
        SmartDashboard.putNumber("pivot speed", speed);
        armPivotMotorLead.set(speed);
    }

}