// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DutyCycleEncoder;

public class Robot extends TimedRobot {
  // Instantiate Through Bore Encoders
  private DutyCycleEncoder encoder_right = new DutyCycleEncoder(0);
  private DutyCycleEncoder encoder_left = new DutyCycleEncoder(1);

  @Override
  public void robotInit() {
    // Set to 0.5 units per rotation
    encoder_right.setDistancePerRotation(0.5);
    encoder_left.setDistancePerRotation(0.5);
  }

  @Override
  public void teleopPeriodic() {
    // Connected can be checked, and uses the frequency of the encoder
    boolean connected_right = encoder_right.isConnected();
    boolean connected_left = encoder_left.isConnected();

    // Duty Cycle Frequency in Hz
    int frequency_right = encoder_right.getFrequency();
    int frequency_left = encoder_left.getFrequency();

    // Output of encoder
    double output_right = encoder_right.get();
    double output_left = encoder_left.get();

    // Output scaled by DistancePerPulse
    double distance_right = encoder_right.getDistance();
    double distance_left = encoder_left.getDistance();

    SmartDashboard.putBoolean("Connected RIGHT Encoder", connected_right);
    SmartDashboard.putBoolean("Connected LEFT Encoder", connected_left);

    SmartDashboard.putNumber("Frequency RIGHT Encoder", frequency_right);
    SmartDashboard.putNumber("Frequency LEFT Encoder", frequency_left);

    SmartDashboard.putNumber("Output RIGHT Encoder", output_right);
    SmartDashboard.putNumber("Output LEFT Encoder", output_left);

    SmartDashboard.putNumber("Distance RIGHT Encoder", distance_right);
    SmartDashboard.putNumber("Distance LEFT Encoder", distance_left);
  }
}
