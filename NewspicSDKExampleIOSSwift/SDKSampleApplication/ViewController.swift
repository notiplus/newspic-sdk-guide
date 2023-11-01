//
//  ViewController.swift
//  SDKSampleApplication
//
//  Created by Notiplus on 10/31/23.
//

import UIKit
import NewspicSDK

class ViewController: UIViewController {
    
    @IBOutlet weak var btnSingleLine: UIButton!
    @IBOutlet weak var btnSingleLineCode: UIButton!
    @IBOutlet weak var btnList: UIButton!
    @IBOutlet weak var btnOpenWebView: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        btnSingleLine.addTarget(self, action: #selector(openSingleLine), for: .touchUpInside)
        btnSingleLineCode.addTarget(self, action: #selector(openSingleLineCode), for: .touchUpInside)
        btnList.addTarget(self, action: #selector(openList), for: .touchUpInside)
        btnOpenWebView.addTarget(self, action: #selector(openOpenWebView), for: .touchUpInside)
    }
    
    func getViewController(_ storyBoardName : String, _ identifier : String) -> UIViewController {
        let storyBoard = UIStoryboard(name: storyBoardName, bundle: nil)
        let vc = storyBoard.instantiateViewController(withIdentifier: identifier)
        vc.modalPresentationStyle = UIModalPresentationStyle.fullScreen
        
        return vc
    }

    @objc
    func openSingleLine(){
        self.present(getViewController("SingleLine","SingleLine"), animated: true)
    }
    
    @objc
    func openSingleLineCode(){
        self.present(getViewController("CodeAppend","CodeAppend"), animated: true)
    }
    
    @objc
    func openList(){
        self.present(getViewController("List","List"), animated: true)
    }
    
    @objc
    func openOpenWebView(){
        self.present(getViewController("OpenWebView","OpenWebView"), animated: true)
    }

}

