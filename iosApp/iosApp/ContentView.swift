import SwiftUI
import shared

struct ContentView: View {
  @ObservedObject private(set) var viewModel: ViewModel

    var body: some View {
        Text(viewModel.result)
    }
}

extension ContentView {
    class ViewModel: ObservableObject {
        let sdk: TestSDK
        @Published var result = "Loading"

        init(sdk: TestSDK) {
            self.sdk = sdk
            self.result = sdk.getResult()
        }
    }
}
