/**
 * 
 */
package com.cloudwick.training.designpattern;

/**
 * @author raki2481
 * 
 */
public class AdminUser implements AuthenticateI {

	@Override
	public boolean authenticate() {
		// TODO Auto-generated method stub
		System.out.println("Message coming from AdminUser Class");
		return false;

	}

}
