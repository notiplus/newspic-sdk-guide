//
//  SingleLineViewController.swift
//  SDKSampleApplication
//
//  Created by Notiplus on 11/1/23.
//

import Foundation
import UIKit
import NewspicSDK

class CodeAppendViewController : UIViewController {
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let gesture = UISwipeGestureRecognizer(target: self, action: #selector(back))
        gesture.direction = .down
        self.view.addGestureRecognizer(gesture)
        
        let height = CGFloat(NewspicSDKViewHeight.SIGLE_LINE.rawValue)
        let newspicView = NewspicSDKView(frame: CGRect(x: 16, y: 400, width: view.bounds.width-height, height: height))
        newspicView.type = .SIGLE_LINE
        newspicView.unitId = "demo"
        view.addSubview(newspicView)
        newspicView.load()
    }
    
    
    @objc func back(_ gesture: UITapGestureRecognizer) {
        self.presentingViewController?.dismiss(animated: true)
    }
}
