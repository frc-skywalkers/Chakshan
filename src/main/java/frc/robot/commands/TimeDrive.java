/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class TimeDrive extends CommandBase {
  /**
   * Creates a new TimeDrive.
   */

  private final DriveTrainSubsystem driveTrainSubsystem;
  private double power;
  private long time; 
  private long endTime; 

  public TimeDrive(DriveTrainSubsystem driveTrain, double speed, long timeInMillis) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.power = speed;
    this.time = timeInMillis;
    this.driveTrainSubsystem = driveTrain;
    addRequirements(this.driveTrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    long startTime = System.currentTimeMillis();
    this.endTime = startTime + this.time;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTrainSubsystem.manualDrive(this.power, this.power);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrainSubsystem.manualDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() >= this.endTime;
  }
}
