package mazeSolve;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeData {
	public static final char ROAD = ' ';
	public static final char WALL = '#';
	private int entranceX,entranceY;
	private int exitX,exitY;
	private int N,M;  //N代表行，M代表列
	private char[][]maze;
	public boolean[][] visited;
	public boolean[][] path;
	public boolean[][] result;
	public int getEntranceX() {
		return entranceX;
	}
	public void setEntranceX(int entranceX) {
		this.entranceX = entranceX;
	}
	public int getEntranceY() {
		return entranceY;
	}
	public void setEntranceY(int entranceY) {
		this.entranceY = entranceY;
	}
	public int getExitX() {
		return exitX;
	}
	public void setExitX(int exitX) {
		this.exitX = exitX;
	}
	public int getExitY() {
		return exitY;
	}
	public void setExitY(int exitY) {
		this.exitY = exitY;
	}
	public int getN() {
		return N;
	}
	public int getM() {
		return M;
	}
	
	public MazeData(String filename) {
		if(filename == null)
			throw new IllegalArgumentException("Filename can not be null");
		Scanner sc = null;
		try {
			File file = new File(filename);
			System.out.println("读取文件");
			if(!file.exists())
				throw new IllegalArgumentException("File "+filename+" doesn't exist!");
			FileInputStream fis = new FileInputStream(file);
			sc = new Scanner(new BufferedInputStream(fis),"UTF-8");
			//读取第一行数字
			String nmline = sc.nextLine();
			String[] nm = nmline.trim().split("\\s+");
			N = Integer.parseInt(nm[0]);
			M = Integer.parseInt(nm[1]);
			maze = new char[N][M];
			visited = new boolean[N][M];
			path = new boolean[N][M];
			result = new boolean[N][M];
			for(int i=0;i<N;i++) {
				String line = sc.nextLine();
				
				//保证每行有M个字符
				if(line.length() != M)
					throw new IllegalArgumentException("File "+filename+" may have error");
				
				for(int j=0;j<M;j++) {
					maze[i][j] = line.charAt(j);
					visited[i][j] = false;
					path[i][j] = false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sc != null)
				sc.close();
		}
		entranceX = 1;
		entranceY = 0;
		exitX = N-2;
		exitY = M-1;
	}

	public char getMaze(int i,int j) {
		if(inArea(i,j) == false)
			throw new IllegalArgumentException("i or j is out of index in getMaze!");
		
		return maze[i][j];
	}
	//判断坐标是否在迷宫内
	public boolean inArea(int x,int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	
	
	public void print() {
		System.out.println(N+" "+M);
		for(int i=0;i<N;i++) {	
			for(int j=0;j<M;j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}
}
