import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Node> list; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(src);

		int A = sc.nextInt(); // 가로
		int B = sc.nextInt(); // 세로
		
		int N = sc.nextInt(); // 로봇의 개수
		int M = sc.nextInt(); // 로봇 명령의 개수
		
		list = new ArrayList<Main.Node>();
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			String c = sc.next();
			
			list.add(new Node((i+1),a,b,c.charAt(0)));
		}
		
//		System.out.println(list);
		int ans = 0;
		for(int i=0; i<M; i++) {
			int num = sc.nextInt();
			String order = sc.next();
			int repeat = sc.nextInt();
			
			if(!out && !clash) {
				ans = num;
				moveRobot(num, order.charAt(0), repeat, A, B);
			}
		}
		
		if(!out && !clash) {
			System.out.println("OK");
		}else if(!out && clash) {
			System.out.println("Robot "+ans+" crashes into robot "+Y);
		}else if(out && !clash) {
			System.out.println("Robot "+ans +" crashes into the wall");
		}
	}
	
	static boolean out;
	static boolean clash;
	static int Y;
	
	static void moveRobot(int num, char order, int repeat, int A, int B) {
//		System.out.println(list);
		Node n = list.get(num-1);
		list.remove(num-1);
//		System.out.println(n);
		if(order=='F') {
			//명령의 반복 횟수
			for(int i=0; i<repeat; i++) {
				if(n.dir=='E') {
					if(n.x+1<=A) {
						n.x+=1;
						for(int j=0; j<list.size(); j++) {
							if(list.get(j).x==n.x && list.get(j).y==n.y) {
								Y = list.get(j).num;
								clash = true;
							}
						}
					}else {
						out = true;
					}
				}else if(n.dir=='W') {
					if(n.x-1>=1) {
						n.x-=1;
						for(int j=0; j<list.size(); j++) {
							if(list.get(j).x==n.x && list.get(j).y==n.y) {
								Y = list.get(j).num;
								clash = true;
							}
						}
					}else {
						out = true;
					}
				}else if(n.dir=='N') {
					if(n.y+1<=B) {
						n.y+=1;
						for(int j=0; j<list.size(); j++) {
							if(list.get(j).x==n.x && list.get(j).y==n.y) {
								Y = list.get(j).num;
								clash = true;
							}
						}
					}else {
						out = true;
					}
				}else if(n.dir=='S') {
					if(n.y-1>=1) {
						n.y-=1;
						for(int j=0; j<list.size(); j++) {
							if(list.get(j).x==n.x && list.get(j).y==n.y) {
								Y = list.get(j).num;
								clash = true;
							}
						}
					}else {
						out = true;
					}
				}
				
				if(out || clash) {
					return;
				}
			}
		}else if(order=='L') {
			int check = repeat%4;
			if(n.dir=='E') {
				if(check==1) {
					n.dir='N';
				}else if(check==2) {
					n.dir='W';
				}else if(check==3) {
					n.dir='S';
				}
			}else if(n.dir=='W') {
				if(check==1) {
					n.dir='S';
				}else if(check==2) {
					n.dir='E';
				}else if(check==3) {
					n.dir='N';
				}
			}else if(n.dir=='N') {
				if(check==1) {
					n.dir='W';
				}else if(check==2) {
					n.dir='S';
				}else if(check==3) {
					n.dir='E';
				}
			}else if(n.dir=='S') {
				if(check==1) {
					n.dir='E';
				}else if(check==2) {
					n.dir='N';
				}else if(check==3) {
					n.dir='W';
				}
			}
		}else if(order=='R') {
			int check = repeat%4;
			if(n.dir=='E') {
				if(check==1) {
					n.dir='S';
				}else if(check==2) {
					n.dir='W';
				}else if(check==3) {
					n.dir='N';
				}
			}else if(n.dir=='W') {
				if(check==1) {
					n.dir='N';
				}else if(check==2) {
					n.dir='E';
				}else if(check==3) {
					n.dir='S';
				}
			}else if(n.dir=='N') {
				if(check==1) {
					n.dir='E';
				}else if(check==2) {
					n.dir='S';
				}else if(check==3) {
					n.dir='W';
				}
			}else if(n.dir=='S') {
				if(check==1) {
					n.dir='W';
				}else if(check==2) {
					n.dir='N';
				}else if(check==3) {
					n.dir='E';
				}
			}
		}
		list.add(num-1, n);
	}
	
	static class Node{
		int num;
		int x, y;
		char dir; //바라보고 있는 방향
		public Node(int num, int x, int y, char dir) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}
		
		
	}

	private static String src = "5 4\r\n" + 
			"2 2\r\n" + 
			"1 1 E\r\n" + 
			"5 4 W\r\n" + 
			"1 F 7\r\n" + 
			"2 F 7";
}
