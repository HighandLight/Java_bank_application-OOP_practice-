# HighAndBright Bank

HighAndBright Bank를 만듭니다.

## Member

- HighAndBright Bank는 회원가입을 해야 사용할 수 있습니다.
- 회원가입시 이름을 입력해야 합니다.
- 이름이 중복되는 경우 에러를 출력합니다.(DuplicatedNameException)
- 회원가입을 성공하면 회원번호, 회원명을 출력합니다.
- 회원번호는 가입하는 순서대로 1부터 순차적으로 1씩 증가하는 번호를 부여합니다.

## Account

- HighAndBright Bank에는 2가지 Account (DepositAccount, GroupDepositAccount)가 있습니다.
- DepositAccount는 일반 저축 통장으로 1명의 Member가 소유합니다.
- GroupDepositAccount는 그룹 저축 통장으로 최대 5명의 Member가 소유합니다.
- Account 생성을 성공하면 계좌번호, 계좌종류(Deposit 혹은 Group)를 출력합니다.
- 계좌번호는 회원번호와 동일하게 생성 순서대로 1부터 순차적으로 1씩 증가하는 번호를 부여합니다.
- 모든 Account는 생성시 Member 정보를 입력해야하며 추후 변경될 수 없습니다.
- 모든 Account는 입금과 출금을 할 수 있습니다.
- 임금 금액에는 제한이 없으며, 출금 시 잔고보다 큰 금액은 출금 할 수 없습니다. 잔고보다 큰 금액을 출금하는 경우 에러를 출력합니다. (NoBalanceException)

## Bank

- 은행은 모든 멤버를 출력할 수 있습니다.
  ```
  // 예시

  bank.printAllMembers();

  /*
    Member List
    1 Kyle
    2 Patrick
    3 Rachel

    // [memberId] [memberName]
  */
  ```
- 은행은 특정 멤버의 계좌 정보를 출력할 수 있습니다.
  ```
  /// 예시

  bank.printMemberAccountDetail(member);
  
  /*
    Patrick has 3 account
    Deposit 30000
    Deposit 40000
    Group   50000 

    // [Account 종류] [Balance]
  */
  ```

## 참고 - Custom RuntimeException

RuntimeException을 상속하여 나만의 Exception을 만들 수 있습니다.
또한 Exception에 있는 message를 활용하여 에러 내용을 출력할 수 있습니다.
```
    // Example

    import java.util.ArrayList;
    import java.util.List;

    public class BankApp {
        public static void main(String[] args) {
            Bank bank = new Bank();
            bank.registerMember("Patrick");
            try {
                bank.registerMember("Patrick");
            } catch (DuplicatedNameException dne) {
                System.err.println(dne.getMessage());
            }

        }
    }

    class DuplicatedNameException extends RuntimeException {
        public DuplicatedNameException(String message) {
            super(message);
        }
    }

    class Member {
        String name;

        public Member(String name) {
            this.name = name;
        }
    }

    class Bank {
        List<Member> members = new ArrayList<>();

    public void registerMember(String name) {
        for (Member member : members) {
            if (member.name.equals(name)) {
                throw new DuplicatedNameException("There is already a member called " + name);
            }
        }
        members.add(new Member(name));
    }

```

## 한 걸음 더

위 내용을 구현 후 추가적인 구현이 하고 싶다면 아래 내용을 구현해보면 좋습니다.

- 특정 Account의 입출금 내역 출력하기
