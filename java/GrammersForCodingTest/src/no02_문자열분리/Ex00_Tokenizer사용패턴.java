package no02_���ڿ��и�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex00_Tokenizer������� {
		
	public static void main(String[] args) throws IOException {
		// 0. ���� ��Ȳ
			// �� - ����, �� - ���ͷ� ���� �����Ͱ� ���� ��
			// readLine�� �� ���� �����Ͱ� ���� nextToken���� �� ���� ���Ұ� �ϳ��� ��������
			// ��, ���� ���� = readLine ���� = st ���� . �� �࿡ ������ ���� = nextToken ����
		
		// 1. ���۸��� (1 ���� ������,  2 �Է����ڸ� ���� ���� �ֱ�)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 2. ���۸����� readLine�� ��ũ�������� �ޱ�
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 3. ��ũ�������� nextToken���� �ϳ��� ������. �� ��, �ʿ��ϸ� ����ȯ
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        int num3 = Integer.parseInt(st.nextToken());
        
        // 4. ���� ���� �ٽ� 1~3 �ݺ�

	}

}
