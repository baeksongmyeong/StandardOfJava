package ch8;

/* catch 문 내에 try ~ catch 가 또 쓰인경우, 예외 인스턴스에 대한 참조변수명이 중복되면 안된다. */

class ExceptionEx1 {
	
	public static void main(String[] args){
		try{
			
			try{
				//
			} catch (Exception e) {

				try {

				//} catch ( Exception e) { // catch 문 안에 다시 try ~ catch 문이 쓰인 경우 예외 인스턴스에 대한 참조변수명이 중복되면 안된다.
				} catch(Exception e1) {
					
				}
			}
			
		} catch (Exception e){
			//
		}
		
		try {
		} catch ( Exception e ){
			//
		}
	}
	
}