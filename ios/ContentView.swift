import SwiftUI

struct ContentView: View {
    @StateObject private var lightMeter = LightMeter()

    var body: some View {
        VStack(spacing: 20) {
            Text("Exposure: \(lightMeter.stopInfo)")
                .font(.largeTitle)
        }
        .padding()
        .onAppear {
            lightMeter.startMetering()
        }
    }
}