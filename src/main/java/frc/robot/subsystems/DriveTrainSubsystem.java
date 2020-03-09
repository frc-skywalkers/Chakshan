/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveTrainSubsystem.
   */

  private CANSparkMax leftMaster = new CANSparkMax(Constants.leftMasterPort, MotorType.kBrushless);
  private CANSparkMax leftSlave = new CANSparkMax(Constants.leftSlavePort, MotorType.kBrushless);
  private CANSparkMax rightMaster = new CANSparkMax(Constants.rightMasterPort, MotorType.kBrushless);
  private CANSparkMax rightSlave = new CANSparkMax(Constants.rightSlavePort, MotorType.kBrushless);

  public DriveTrainSubsystem() {

    leftMaster.restoreFactoryDefaults();
    leftSlave.restoreFactoryDefaults();

    rightMaster.restoreFactoryDefaults();
    rightSlave.restoreFactoryDefaults();

    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);

    rightMaster.setInverted(true);

    

  }

  public void manualDrive(double leftPower, double rightPower) {
    leftMaster.set(leftPower);
    rightMaster.set(rightPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
