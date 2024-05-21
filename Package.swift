// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "VvScreenorientation",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "VvScreenorientation",
            targets: ["VVScreenOrientationPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "VVScreenOrientationPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/VVScreenOrientationPlugin"),
        .testTarget(
            name: "VVScreenOrientationPluginTests",
            dependencies: ["VVScreenOrientationPlugin"],
            path: "ios/Tests/VVScreenOrientationPluginTests")
    ]
)