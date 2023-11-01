//
//  SingleLineViewController.swift
//  SDKSampleApplication
//
//  Created by Notiplus on 11/1/23.
//

import Foundation
import UIKit
import NewspicSDK

class ListViewController : UIViewController {
    
    
    @IBOutlet weak var newspicView: NewspicSDKView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let gesture = UISwipeGestureRecognizer(target: self, action: #selector(back))
        gesture.direction = .down
        self.view.addGestureRecognizer(gesture)
        
        
        //NewspicSDKView의 타입을 지정합니다.
        newspicView.type = .LIST
        //전달받은 unitId를 설정합니다.
        newspicView.unitId = "demo"
        //NewspicSDKView를 로드합니다.
        newspicView.load()
    }
    
    
    @objc func back(_ gesture: UITapGestureRecognizer) {
        self.presentingViewController?.dismiss(animated: true)
    }
}
