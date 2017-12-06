//
//  ViewController.swift
//  MovieBrowser
//
//  Created by Mark Struzinski on 11/7/17.
//  Copyright © 2017 BobStruz Software. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    let searchManager = SearchNetworkManager()
    
    @IBOutlet weak var activityIndicator: UIActivityIndicatorView!
    
    var movies: [Movie]? {
        didSet {
            if let movieResults = movies {
                print(movieResults)
            }
        }
    }
    
    @IBAction func runSearch(_ sender: UIButton) {
        activityIndicator.startAnimating()
        searchManager.performSearch(with: "terminator") { result in
            defer {
                DispatchQueue.main.async {
                    self.activityIndicator.stopAnimating()
                }
            }
            
            switch result {
            case .success(let movies):
                guard let movieResults = movies else {
                    print("No movies returned")
                    return
                }
                
                self.movies = movieResults
            case .error(let error):
                print("Error encountered: \(error)")
                
            }
        }
    }
}

