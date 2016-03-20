package netqu;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class paintpanel extends JPanel {
	private DAO mps;
	public paintpanel(){
//		 mps=new DAO(somefinals.DIANSHU,somefinals.x0,somefinals.y0,somefinals.r);
		 mps=new DAO();
	}
	public void paint(Graphics g) {  
	 Graphics2D g2d = (Graphics2D) g;
	 	super.paint(g);//不加这句 repaint不能清除之前的画面
		if(mps.status==0){
			g2d.setColor(Color.red);
			//g.fillPolygon(mps.x,mps.y,somefinals.DIANSHU);
			for(int i=0;i<somefinals.DIANSHU;i++){
				g2d.fillOval(mps.px[i]-3, mps.py[i]-3, 6, 6);//第零个点为最左边的点 顺时针编号
			}
		}
		else if(mps.status==1){
			g2d.setColor(Color.RED);
			for(int i=0;i<somefinals.DIANSHU;i++){
				g2d.fillOval(mps.px[i]-3, mps.py[i]-3, 6, 6);//第零个点为最左边的点 顺时针编号
				Stroke od=g2d.getStroke();
				Color olc=g2d.getColor();
				g2d.setColor(new Color(75,134,70));
				g2d.setStroke(new BasicStroke(0.5f,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_ROUND,3.5f,new float[]{5,10},0f));
				g2d.drawOval((int)(mps.px[i]-somefinals.COVERDIS), (int)(mps.py[i]-somefinals.COVERDIS),(int)( 2*somefinals.COVERDIS),(int)( 2*somefinals.COVERDIS));
				g2d.setStroke(od);
				g2d.setColor(olc);
			}
			Color curcolor=g.getColor();
			g2d.setColor(Color.BLUE);
			g2d.setStroke(new BasicStroke(1));
			for(int i=0;i<mps.edges.size();i++){
				g2d.drawLine(mps.px[mps.edges.get(i).p1], mps.py[mps.edges.get(i).p1], mps.px[mps.edges.get(i).p2], mps.py[mps.edges.get(i).p2]);
			}
			g2d.setColor(curcolor);
		}
		else if(mps.status==2){
			g2d.setColor(Color.red);
			for(int i=0;i<somefinals.DIANSHU;i++){
				g2d.fillOval(mps.px[i]-3, mps.py[i]-3, 6, 6);//第零个点为最左边的点 顺时针编号
				Stroke od=g2d.getStroke();
				Color olc=g2d.getColor();
				g2d.setColor(new Color(75,134,70));
				g2d.setStroke(new BasicStroke(0.5f,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_ROUND,3.5f,new float[]{5,10},0f));
				g2d.drawOval((int)(mps.px[i]-somefinals.COVERDIS), (int)(mps.py[i]-somefinals.COVERDIS),(int)( 2*somefinals.COVERDIS),(int)( 2*somefinals.COVERDIS));
				g2d.setStroke(od);
				g2d.setColor(olc);
			}
			Color curcolor=g.getColor();
			g2d.setColor(Color.BLUE);
			g2d.setStroke(new BasicStroke(1));
			for(int i=0;i<mps.edges.size();i++){
				g2d.drawLine(mps.px[mps.edges.get(i).p1], mps.py[mps.edges.get(i).p1], mps.px[mps.edges.get(i).p2], mps.py[mps.edges.get(i).p2]);
			}
			g2d.setColor(curcolor);
			int cur=mps.ed;
			g2d.setStroke(new BasicStroke(1));
			while(mps.zuiduanpre[cur]!=cur){
				System.out.println(mps.zuiduanpre[cur]);
				g2d.drawLine(mps.px[cur], mps.py[cur], mps.px[mps.zuiduanpre[cur]], mps.py[mps.zuiduanpre[cur]]);
				cur=mps.zuiduanpre[cur];
			}
			
		}
		else System.out.println("error!!!");
	}
	public void shengchengtu(){
			mps.randomcreate();
			mps.status=1;
			repaint();
	}
	public void showpath(int st,int ed){
		if(mps.status<1) return;
		mps.status=2;
		if(dijkstra(st,ed)){
			mps.ed=ed;
			System.out.println("ok" );
			repaint();
		
		}
		else System.out.println("no" );
		
	}
	public String getquanzhi(int p1,int p2){
		for(int i=0;i<mps.edges.size();i++){
			if((mps.edges.get(i).p1==p1&&mps.edges.get(i).p2==p2)||(mps.edges.get(i).p1==p2&&mps.edges.get(i).p2==p1)){
				return String.valueOf(mps.edges.get(i).bw_h);
			}
		}
		return "0";
	}
	private boolean dijkstra(int st,int ed){
		System.out.println(st+" "+ed );
//		System.out.println(mps.maps[st][ed]);
		double dis[]=new double[somefinals.DIANSHU+1];
		boolean vis[]=new boolean[somefinals.DIANSHU+1];
		Arrays.fill(dis,somefinals.INF);
		Arrays.fill(vis, false);
		Arrays.fill(mps.zuiduanpre, -1);
//		double MIN=somefinals.INF;
		mps.zuiduanpre[st]=st;
		dis[st]=0;
		int cur=somefinals.DIANSHU+1;
		for(int j=0;j<somefinals.DIANSHU-1;j++){
			double MIN=somefinals.INF;
			for(int i=0;i<somefinals.DIANSHU;i++){
				if(dis[i]<MIN && !vis[i]){
					MIN=dis[i];
					cur=i;
					
				}
			}
			for(int i=0;i<somefinals.DIANSHU;i++){
				if(dis[i]>mps.maps[i][cur]+dis[cur]) {
					dis[i]=mps.maps[i][cur]+dis[cur];
					mps.zuiduanpre[i]=cur;
				}
			}
			vis[cur]=true;
		}
		System.out.println(dis[ed]);
		if(dis[ed]<somefinals.INF){
			return true;
		}
		return false;
	}
	public int getid(int x, int y) {
		for(int i=0;i<somefinals.DIANSHU;++i){
			if(((mps.px[i]-x)*(mps.px[i]-x)+(mps.py[i]-y)*(mps.py[i]-y))<=100) return i;
		}
		
		return 1000;
	}
}
