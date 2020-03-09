/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

// Testing 1234

public class DriveManually extends CommandBase {
  /**
   * Creates a new DriveManually.
   */

  private final DriveTrainSubsystem driveTrainSubsystem;
  private double xAxis;
  private double yAxis;

  public DriveManually(double x, double y, DriveTrainSubsystem driveTrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.xAxis = x;
    this.yAxis = y;
    this.driveTrainSubsystem = driveTrain;
    addRequirements(this.driveTrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPower = this.yAxis + this.xAxis;
    double rightPower = this.yAxis - this.xAxis;
    this.driveTrainSubsystem.manualDrive(leftPower, rightPower);
  }

  
}
