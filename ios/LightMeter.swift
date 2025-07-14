import Foundation
import AVFoundation

class LightMeter: NSObject, ObservableObject {
    private let session = AVCaptureSession()
    private var videoInput: AVCaptureDeviceInput?
    private let output = AVCaptureVideoDataOutput()
    @Published var stopInfo: String = "Loading..."

    func startMetering() {
        guard let device = AVCaptureDevice.default(for: .video) else { return }
        do {
            videoInput = try AVCaptureDeviceInput(device: device)
            if session.canAddInput(videoInput!) {
                session.addInput(videoInput!)
            }
            session.startRunning()
            Timer.scheduledTimer(withTimeInterval: 1.0, repeats: true) { _ in
                self.updateEV(using: device)
            }
        } catch {
            print("Error setting up camera input: \(error)")
        }
    }

    private func updateEV(using device: AVCaptureDevice) {
        device.unlockForConfiguration()
        let brightnessValue = device.exposureDuration.seconds * Double(device.iso)
        let ev = log2(100 / brightnessValue)
        let stopDiff = Int(round(ev - 14))
        DispatchQueue.main.async {
            self.stopInfo = stopDiff == 0 ? "0 stop" : "\(stopDiff > 0 ? "+" : "")\(stopDiff) stop"
        }
    }
}