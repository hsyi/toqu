package netqu;

import java.awt.Point;
import java.util.ArrayList;

public class DAO{
	public int[] px;
	public int[] py;
	public int ed;
	public int status;//status=0 �����ɵ㣬1������ͼ��2�������·����
//	private int r;
	private int dianshu;
//	public netline[] edges;
	ArrayList<netline> edges;
	public double maps[][];
	public int zuiduanpre[];
	private boolean ee[][];
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
		for(int rows=0;rows<somefinals.ROWS;++rows){
			for(int cols=0;cols<somefinals.COLS;++cols){
				px[rows*somefinals.COLS+cols]=px[0]+(cols-0)*somefinals.ColInter;
				py[rows*somefinals.COLS+cols]=py[0]+(rows-0)*somefinals.RowInter;
			}
		}
	}                                        
//	private Point calpoint(double arc){ Բ�ε�ʱ���ջ��ȼ�����λ��
//		Point p = new Point();
//		p.y=(int)(py[0]-Math.sin(arc)*r);
//		p.x=(int)(px[0]+r-Math.cos(arc)*r);//ȷ��x0 y0 ������ߵ�һ����
//		return p;
//	}
	public void randomcreate( ){
		ee=new boolean[somefinals.DIANSHU][somefinals.DIANSHU];
		maps=new double[somefinals.DIANSHU][somefinals.DIANSHU];
//		edges=new netline[somefinals.edgesnum]; //���������ʼ���ر�
		edges=new ArrayList<netline>();
		for(int i=0;i<somefinals.DIANSHU;i++)//ee���ֵ
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
//		for(int i=0;i<somefinals.edgesnum;i++){
//			int a=(int) (Math.random()*somefinals.DIANSHU);
//			int b=(int) (Math.random()*somefinals.DIANSHU);
//			if(ee[a][b]) {i--;continue;}//i--��֤�˲����ı���������
//			ee[a][b]=ee[b][a]=true;
//			System.out.println(a+" "+b);
//			edges[i]=new netline(); //���������ʼ���ر�
//			edges[i].p1=a;
//			edges[i].p2=b;
//			maps[b][a]=maps[a][b]=edges[i].bw_h=1024+Math.random()*500;
//			edges[i].bw_l=1024-Math.random()*500;
//			/* �˴����б��Ȩֵʲô��ûд����*/
//		}
		for(int rows=0;rows<somefinals.ROWS;rows++)
			for(int cols=0;cols<somefinals.COLS;cols++){
				if(cols!=somefinals.COLS-1){
					int ex=(int)(Math.random()*2); //ex==1�ñߴ���
					if(ex==1){
						netline e=new netline();
						int a=e.p1=rows*somefinals.COLS+cols;
						int b=e.p2=rows*somefinals.COLS+cols+1;
						maps[b][a]=maps[a][b]=e.bw_h=1024+Math.random()*500;
						edges.add(e);
						System.out.println(a+"   "+b);
					}
				}
				if(rows!=somefinals.ROWS-1){
					int ex=(int)(Math.random()*2); //ex==1�ñߴ���
					if(ex==1){
						netline e=new netline();
						int a=e.p1=(rows+1)*somefinals.COLS+cols;
						int b=e.p2=(rows)*somefinals.COLS+cols;
						maps[b][a]=maps[a][b]=e.bw_h=1024+Math.random()*500;
						edges.add(e);
						System.out.println(a+"   "+b);
					}
				}
			}
	}
	
}