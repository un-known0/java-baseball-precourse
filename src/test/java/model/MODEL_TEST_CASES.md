# Model JUnit5 테스트 케이스 목록

이 문서는 `model` 패키지에 대한 JUnit5 테스트 케이스를 정리한다.

## RandomNumberGenerator

### pickNumber(start, end)
- 정상 범위: `start == end`일 때 반환값이 그 값인지
- 정상 범위: `start < end`일 때 반환값이 `start..end` 범위 내인지 (여러 번 반복)
- 예외: `start > end`이면 `IllegalArgumentException` 발생

### pickUniqueNumbers(start, end, count)
- 정상: `count == 0`이면 빈 리스트 반환
- 정상: `count > 0`이고 범위가 충분할 때 리스트 크기가 `count`인지
- 정상: 반환 리스트가 모두 `start..end` 범위 내인지
- 정상: 반환 리스트에 중복이 없는지
- 예외: `end - start + 1 < count`이면 `IllegalArgumentException` 발생
- 예외: `count < 0`이면 `IllegalArgumentException` 발생
- 참고: `start > end`인 경우는 별도 검증이 없으므로 `count > 0`일 때는 `pickNumber`에서 예외가 발생함

## GameResult

### constructor / getters
- 정상: 생성 시 전달한 `ball`, `strike`가 그대로 반환되는지

### isGameOver(numberSize)
- 정상: `numberSize == strike`이면 `true`
- 정상: `numberSize != strike`이면 `false`
- 경계: `numberSize == 0`일 때 `strike == 0`이면 `true`

## BaseballGameJudge

### countBall(answer, guess)
- 정상: 모든 숫자가 위치만 다를 때 볼 개수 정확히 계산
- 정상: 같은 숫자가 같은 위치면 볼로 카운트하지 않음
- 정상: 중복이 없는 입력에서 볼 계산이 기대값인지
- 참고: 입력 리스트 길이 검증이 없으므로 길이가 다른 경우는 현재 구현상 정의되지 않음

### countStrike(answer, guess)
- 정상: 같은 위치 같은 숫자 개수 계산
- 정상: 전부 일치 시 `strike == 길이`

### judge(answer, guess)
- 정상: `countBall`과 `countStrike` 결과로 `GameResult` 생성되는지
- 정상: 볼/스트라이크가 모두 0이면 0/0 반환되는지

## InputValidator

### parseToNumbers(input, min, max, size)
- 정상: 숫자 문자열이 리스트로 변환되는지
- 정상: 앞뒤 공백이 있는 경우에도 정상 파싱되는지
- 예외: `null` 입력이면 `InvalidInputException(INVALID_INPUT_EMPTY)`
- 예외: 빈 문자열/공백 문자열이면 `InvalidInputException(INVALID_INPUT_EMPTY)`
- 예외: 숫자 외 문자가 포함되면 `InvalidInputException(INVALID_INPUT_FORMAT)`
- 예외: 길이가 `size`와 다르면 `InvalidInputException(INVALID_LENGTH)`
- 예외: 길이가 `size`보다 길면 `InvalidInputException(INVALID_LENGTH)`
- 예외: 범위 밖 숫자가 있으면 `InvalidInputException(INVALID_NUMBER_RANGE)`
- 예외: 중복이 있으면 `InvalidInputException(DUPLICATE_NUMBER)`

### validateRange(numbers, min, max)
- 정상: 모두 범위 내면 예외 없음
- 예외: 범위 밖 숫자가 하나라도 있으면 `InvalidInputException(INVALID_NUMBER_RANGE)`

### validateLength(numbers, size)
- 정상: 길이가 같으면 예외 없음
- 예외: 길이가 다르면 `InvalidInputException(INVALID_LENGTH)`

### validateNoDuplicates(numbers)
- 정상: 중복 없으면 예외 없음
- 예외: 중복 있으면 `InvalidInputException(DUPLICATE_NUMBER)`

### validateRestartInput(input)
- 정상: `"1"`이면 `true`
- 정상: `"2"`이면 `false`
- 정상: 앞뒤 공백이 있어도 `"1"`/`"2"`는 허용
- 예외: `null`이면 `NullPointerException`
- 예외: 빈 문자열이면 `InvalidInputException(INVALID_INPUT_EMPTY)`
- 예외: 공백만 있는 문자열이면 `InvalidInputException(INVALID_RESTART_INPUT)`
- 예외: 그 외 문자열이면 `InvalidInputException(INVALID_RESTART_INPUT)`
