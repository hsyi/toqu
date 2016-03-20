package netqu;

import java.awt.Point;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DAO{
	public int[] px;
	public int[] py;
	public int ed;
	public int status;//status=0 刚生成点，1生成了图，2找了最短路径；
//	private int r;
	private int dianshu;
//	public netline[] edges;
	ArrayList<netline> edges;
	public double maps[][];
	public int zuiduanpre[];
	private boolean ee[][];
	static int createtimes=1;
//	public DAO(int _dianshu,int x0,int y0,int _r){
	public DAO(){
		status=0;
		px=new int[somefinals.DIANSHU];
		py=new int[somefinals.DIANSHU];
		zuiduanpre=new int[somefinals.DIANSHU];
		px[0]=somefinals.x0;
		py[0]=somefinals.y0;
//		dianshu=_dianshu;
//		r=_r;
//		Point p=new Point();
//		double arc = 0;
//		double deltarc=(Math.PI*2)/dianshu;
//		for(int i=1;i<dianshu;i++){
//			arc+=deltarc;
//			p=calpoint(arc);
//			px[i]=p.x;
//			py[i]=p.y;
//		}

//		//System.out.println(somefinals.DIANSHU);
//		for(int rows=0;rows<somefinals.ROWS;++rows){
//			for(int cols=0;cols<somefinals.COLS;++cols){
//				px[rows*somefinals.COLS+cols]=px[0]+(cols-0)*somefinals.ColInter;
//				py[rows*somefinals.COLS+cols]=py[0]+(rows-0)*somefinals.RowInter;
//			}
//		}
		for(int i=0;i<somefinals.DIANSHU;++i){
			px[i]=(int)(somefinals.WIDTH*Math.random())+101;
			py[i]=(int)(somefinals.HEIGHT*Math.random())+101;
		}
	}                                        
//	private Point calpoint(double arc){ 圆形的时候按照弧度计算点的位置
//		Point p = new Point();
//		p.y=(int)(py[0]-Math.sin(arc)*r);
//		p.x=(int)(px[0]+r-Math.cos(arc)*r);//确定x0 y0 是最左边的一个点
//		return p;
//	}
	public void randomcreate( ){
		if(createtimes>1){
			for(int i=0;i<somefinals.DIANSHU;++i){
				px[i]=(int)(somefinals.WIDTH*Math.random())+101;
				py[i]=(int)(somefinals.HEIGHT*Math.random())+101;
			}
		}
		createtimes++;
		ee=new boolean[somefinals.DIANSHU][somefinals.DIANSHU];
		maps=new double[somefinals.DIANSHU][somefinals.DIANSHU];
//		edges=new netline[somefinals.edgesnum]; //对象数组初始化必备
		edges=new ArrayList<netline>();
		for(int i=0;i<somefinals.DIANSHU;i++){//ee设初值
			for(int j=0;j<somefinals.DIANSHU;j++){
				if(i!=j) {
					ee[i][j]=false;
					maps[i][j]=somefinals.INF;
				}
				else{ 
					ee[i][j]=true;
					maps[i][j]=0;
				}
			}
		}
//		for(int i=0;i<somefinals.edgesnum;i++){
//			int a=(int) (Math.random()*somefinals.DIANSHU);
//			int b=(int) (Math.random()*somefinals.DIANSHU);
//			if(ee[a][b]) {i--;continue;}//i--保证了产生的边数不减少
//			ee[a][b]=ee[b][a]=true;
//			System.out.println(a+" "+b);
//			edges[i]=new netline(); //对象数组初始化必备
//			edges[i].p1=a;
//			edges[i].p2=b;
//			maps[b][a]=maps[a][b]=edges[i].bw_h=1024+Math.random()*500;
//			edges[i].bw_l=1024-Math.random()*500;
//			/* 此处还有别的权值什么的没写上来*/
//		}
//-----------------------------------------------------------------
//		for(int rows=0;rows<somefinals.ROWS;rows++)
//			for(int cols=0;cols<somefinals.COLS;cols++){
//				if(cols!=somefinals.COLS-1){
//					int ex=(int)(Math.random()*2); //ex==1该边存在
//					if(ex==1){
//						netline e=new netline();
//						int a=e.p1=rows*somefinals.COLS+cols;
//						int b=e.p2=rows*somefinals.COLS+cols+1;
//						maps[b][a]=maps[a][b]=e.bw_h=1024+Math.random()*500;
//						edges.add(e);
//						System.out.println(a+"   "+b);
//					}
//				}
//				if(rows!=somefinals.ROWS-1){
//					int ex=(int)(Math.random()*2); //ex==1该边存在
//					if(ex==1){
//						netline e=new netline();
//						int a=e.p1=(rows+1)*somefinals.COLS+cols;
//						int b=e.p2=(rows)*somefinals.COLS+cols;
//						maps[b][a]=maps[a][b]=e.bw_h=1024+Math.random()*500;
//						edges.add(e);
//						System.out.println(a+"   "+b);
//					}
//				}
//			}
		boolean issingle[];
		issingle=new boolean[somefinals.DIANSHU];
		int mindis[];
		int minid[];
//		mindis=new int[somefinals.DIANSHU];
//		minid=new int[somefinals.DIANSHU];
//		Arrays.fill(issingle, true);
//		Arrays.fill(mindis, somefinals.INF);
		for(int i=0;i<somefinals.DIANSHU;++i){
			for(int j=i+1;j<somefinals.DIANSHU;++j){
				double curdis=Math.pow((double)((px[i]-px[j])*(px[i]-px[j])+(py[i]-py[j])*(py[i]-py[j])),0.5);
//				if(curdis<mindis[i]) {
//					minid[i]=j;
//					mindis[i]=curdis;
//				}
				if(curdis<=somefinals.COVERDIS){
					netline e=new netline();
					int a=i;
					int b=j;
					issingle[a]=false;
					maps[b][a]=maps[a][b]=e.bw_h=1024+Math.random()*500;
					e.p1=a;
					e.p2=b;
					edges.add(e);
					System.out.println(a+"   "+b);
				}
			}
//			if(issingle[i]){
//				netline e=new netline();
//				int a=i;
//				int b=minid[i];
//				issingle[a]=false;
//				e.p1=a;
//				e.p2=b;
//				maps[b][a]=maps[a][b]=e.bw_h=1024+Math.random()*500;
//				edges.add(e);
//				System.out.println(a+"   "+b);
//			}
		}
			
		
	}
	
	
}