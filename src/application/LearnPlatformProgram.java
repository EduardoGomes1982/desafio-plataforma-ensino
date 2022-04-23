package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import application.entities.Lesson;
import application.entities.Task;
import application.entities.Video;

public class LearnPlatformProgram {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso? ");
		int n = sc.nextInt();
		System.out.println();
				
		for (int i = 0; i < n; i++) {
			System.out.printf("Dados da %da aula:", i + 1);
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char ch = sc.next().charAt(0);
			sc.nextLine();
			System.out.println("Título: ");
			String title = sc.nextLine();
			
			if (ch == 'c') {
				System.out.print("URL do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				int sec = sc.nextInt();
				list.add(new Video(title, url, sec));
			} else {
				System.out.print("Descrição: ");
				String desc = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int qCount = sc.nextInt();
				list.add(new Task(title, desc, qCount));
			}
			
			sc.nextLine();
			System.out.println();
		}
		
		int sum = 0;
		
		for (Lesson l : list)
			sum += l.duration();
		
		System.out.printf("DURAÇÃO TOTAL DO CURSO = %d segundos", sum);
		sc.close();
	}
}
