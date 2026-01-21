#encoding: UTF-8
$employees = ["직원A", "직원B", "직원C"]
$basePays = [400, 300, 250]

# 직원 급여 계산
def main(name)
  taxRate = getTaxRate()
  pay = calculatePayFor(name, taxRate)
  puts(describeResult(name, pay))
end


# 소득세율
def getTaxRate()
  print("세율을 입력하세요: ")
  return gets().chomp().to_f()
end

# 급여 계산
def calculatePayFor(name, taxRate)
  index = $employees.index(name)
  basePay = $basePays[index] # 기본급
  return basePay - (basePay * taxRate)
end

# 결과 출력
def describeResult(name, pay)
  return "이름 : #{name}, 급여 : #{pay}"
end

main("직원A")