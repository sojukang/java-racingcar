package racingcar.view;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
	private static final String POSITIVE_REGEX = "^[1-9]+[0-9]*$";

	private static final Scanner scanner = new Scanner(System.in);

	private void validatePositiveInput(String input) {
		if (!input.matches(POSITIVE_REGEX)) {
			throw new IllegalArgumentException("양수를 입력해주세요.");
		}
	}

	private void validateEmptyInput(String input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("빈 값을 입력하셨습니다. 양수를 입력해주세요.");
		}
	}

	@Override
	public String getCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		return scanner.nextLine();
	}

	@Override
	public int getIterationNumber() {
		System.out.println("시도할 회수는 몇회인가요?");
		String input = scanner.nextLine();
		try {
			validateIterationNumber(input);
			return Integer.parseInt(input);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return getIterationNumber();
		}
	}

	@Override
	public void validateIterationNumber(String input) {
		validateEmptyInput(input);
		validatePositiveInput(input);
	}
}
