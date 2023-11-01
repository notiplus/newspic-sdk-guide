//
//  OpenWebViewViewController.swift
//  SDKSampleApplication
//
//  Created by notiplus on 11/15/23.
//

import Foundation
import UIKit
import NewspicSDK


class OpenWebViewViewController : UIViewController {
    
    @IBOutlet weak var textLink: UITextView!
    @IBOutlet weak var btnOpen: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let gesture = UISwipeGestureRecognizer(target: self, action: #selector(back))
        gesture.direction = .down
        self.view.addGestureRecognizer(gesture)
        
        btnOpen.addTarget(self, action: #selector(open), for: .touchUpInside)
        
    }
    
    
    @objc func back(_ gesture: UITapGestureRecognizer) {
        self.presentingViewController?.dismiss(animated: true)
    }
    
    @objc func open(_ gesture: UITapGestureRecognizer) {
        let url = textLink.text
        NewspicDetailViewController.launch(url, self)
    }
}
