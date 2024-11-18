type UserType = 'STUDENT' | 'SENIOR' | 'EMPLOYEE';

interface Discount {
    rate: number;
    userType: UserType;
    isHoliday: boolean;
}

export function calculateDiscount(price: number, userType: UserType, isHoliday: boolean): Discount {
    let discountRate = 0;

    if (userType === 'STUDENT') {
        discountRate = price * 0.1;
    } else if (userType === 'SENIOR') {
        discountRate = price * 0.15;
    } else if (userType === 'EMPLOYEE') {
        discountRate = price * 0.2;
    } else {
        discountRate = 0;
    }

    if (isHoliday) {
        discountRate += price * 0.05;
    }

    return {
        rate: discountRate,
        userType: userType,
        isHoliday: isHoliday
    };
}