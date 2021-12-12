; ModuleID = 'generatedLLVMcode'

@.str = private constant [4 x i8] c"%f\0A\00"

@.strerr = private constant [16 x i8] c"Out of bounds!\0A\00"

define void @print(double %d) nounwind ssp {
  %1 = alloca double
  store double %d, double* %1
  %2 = load double, double* %1
  %cast210 = getelementptr inbounds [4 x i8], [4 x i8]* @.str, i64 0, i64 0
  %3 = call i64 (i8*, ...) @printf(i8* %cast210, double %2)
  ret void
}

define void @error() nounwind ssp {
  %cast210 = getelementptr inbounds [16 x i8], [16 x i8]* @.strerr, i64 0, i64 0
  %1 = call i64 (i8*, ...) @printf(i8* %cast210)
  ret void
}

declare i64 @printf(i8*, ...)
declare i8* @malloc(i64) #1

define i64 @main() nounwind ssp {



%p1 = alloca i8*
%1 = call i8* @malloc(i64 16)
%2 = bitcast i8* %1 to double*
%3 = fadd double 15.0, 0.0
%4 = getelementptr inbounds double, double* %2, i64 0
store double %3, double* %4
%5 = fadd double 30.0, 0.0
%6 = getelementptr inbounds double, double* %2, i64 1
store double %5, double* %6
%7 = bitcast double* %2 to i8*
store i8* %7, i8** %p1
%p2 = alloca i8*
%8 = call i8* @malloc(i64 16)
%9 = bitcast i8* %8 to double*
%10 = fadd double 200.0, 0.0
%11 = getelementptr inbounds double, double* %9, i64 0
store double %10, double* %11
%12 = fadd double 300.0, 0.0
%13 = getelementptr inbounds double, double* %9, i64 1
store double %12, double* %13
%14 = bitcast double* %9 to i8*
store i8* %14, i8** %p2
%area = alloca double
%15 = load i8*, i8** %p2
%16 = bitcast i8* %15 to double*
%17 = getelementptr inbounds double, double* %16, i64 0
%18 = load double, double* %17
%19 = load i8*, i8** %p1
%20 = bitcast i8* %19 to double*
%21 = getelementptr inbounds double, double* %20, i64 0
%22 = load double, double* %21
%23 = fsub double %18, %22
%24 = load i8*, i8** %p2
%25 = bitcast i8* %24 to double*
%26 = getelementptr inbounds double, double* %25, i64 1
%27 = load double, double* %26
%28 = load i8*, i8** %p1
%29 = bitcast i8* %28 to double*
%30 = getelementptr inbounds double, double* %29, i64 1
%31 = load double, double* %30
%32 = fsub double %27, %31
%33 = fmul double %23, %32
store double %33, double* %area
%line = alloca i8*
%34 = call i8* @malloc(i64 16)
%35 = bitcast i8* %34 to double*
%36 = load i8*, i8** %p1
%37 = getelementptr inbounds double, double* %35, i64 0
%38 = bitcast double* %37 to i8**
store i8* %36, i8** %38
%39 = load i8*, i8** %p2
%40 = getelementptr inbounds double, double* %35, i64 1
%41 = bitcast double* %40 to i8**
store i8* %39, i8** %41
%42 = bitcast double* %35 to i8*
store i8* %42, i8** %line
%slope = alloca double
%43 = load i8*, i8** %line
%44 = bitcast i8* %43 to double*
%45 = getelementptr inbounds double, double* %44, i64 1
%46 = bitcast double* %45 to i8**
%47 = load i8*, i8** %46
%48 = bitcast i8* %47 to double*
%49 = getelementptr inbounds double, double* %48, i64 1
%50 = load double, double* %49
%51 = load i8*, i8** %line
%52 = bitcast i8* %51 to double*
%53 = getelementptr inbounds double, double* %52, i64 0
%54 = bitcast double* %53 to i8**
%55 = load i8*, i8** %54
%56 = bitcast i8* %55 to double*
%57 = getelementptr inbounds double, double* %56, i64 1
%58 = load double, double* %57
%59 = fsub double %50, %58
%60 = load i8*, i8** %line
%61 = bitcast i8* %60 to double*
%62 = getelementptr inbounds double, double* %61, i64 1
%63 = bitcast double* %62 to i8**
%64 = load i8*, i8** %63
%65 = bitcast i8* %64 to double*
%66 = getelementptr inbounds double, double* %65, i64 0
%67 = load double, double* %66
%68 = load i8*, i8** %line
%69 = bitcast i8* %68 to double*
%70 = getelementptr inbounds double, double* %69, i64 0
%71 = bitcast double* %70 to i8**
%72 = load i8*, i8** %71
%73 = bitcast i8* %72 to double*
%74 = getelementptr inbounds double, double* %73, i64 0
%75 = load double, double* %74
%76 = fsub double %67, %75
%77 = fdiv double %59, %76
store double %77, double* %slope
%78 = load i8*, i8** %line
%79 = bitcast i8* %78 to double*
%80 = getelementptr inbounds double, double* %79, i64 0
%81 = bitcast double* %80 to i8**
%82 = load i8*, i8** %81
%83 = bitcast i8* %82 to double*
%84 = getelementptr inbounds double, double* %83, i64 0
%85 = load double, double* %84
%86 = fadd double 30.0, 0.0
store double %86, double* %83
%87 = load double, double* %area
call void @print(double %87)


ret i64 0
}

