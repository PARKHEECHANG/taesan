import axios from 'axios';
import { REACT_APP_URL, HABITS } from 'constants/API_URL';

// getTotalCalendarMonth
export const getTotalCalendarMonth = async (year: string, month: string) => {
  try {
    const response = await axios.get(`${REACT_APP_URL}${HABITS}/calendar/month?year=${year}&month=${month}`);
    return response.data;
  } catch (error) {
    console.error('An error occurred while fetching data: ', error);
  }
};

// getTotalCalendarDay
export const getTotalCalendarDay = async (year: string, month: string, day: string) => {
  try {
    const response = await axios.get(`${REACT_APP_URL}${HABITS}/calendar/day?year=${year}&month=${month}&day=${day}`);
    return response.data;
  } catch (error) {
    console.error('An error occurred while fetching data: ', error);
  }
};

// getBuying
export const getBuying = async () => {
  try {
    const response = await axios.get(`${REACT_APP_URL}${HABITS}/buying`);
    return response.data;
  } catch (error) {
    console.error('An error occurred while fetching data: ', error);
  }
};

// postNewHabit
export const postNewHabit = async (data: any) => {
  try {
    const response = await axios.post(`${REACT_APP_URL}${HABITS}/new`, {
      title: '제목', //습관 제목
      habit: '금연', //선택 습관
    });
    return response.data;
  } catch (error) {
    console.error('An error occurred while fetching data: ', error);
  }
};

// getProgress
export const getProgress = async () => {
  try {
    const response = await axios.get(`${REACT_APP_URL}${HABITS}/progress`);
    return response.data;
  } catch (error) {
    console.error('An error occurred while fetching data: ', error);
  }
};

// putHabitEnd
const habitId = 1;
export const putHabitEnd = async () => {
  try {
    const response = await axios.put(`${REACT_APP_URL}${HABITS}/${habitId}/end`);
    return response.data;
  } catch (error) {
    console.error('An error occurred while fetching data: ', error);
  }
};

// getHabitComplete
export const getHabitComplete = async () => {
  try {
    const response = await axios.get(`${REACT_APP_URL}${HABITS}/complete`);
    return response.data;
  } catch (error) {
    console.error('An error occurred while fetching data: ', error);
  }
};
// getHabitDetail
export const getHabitDetail = async () => {
  try {
    const response = await axios.get(`${REACT_APP_URL}${HABITS}/${habitId}`);
    return response.data;
  } catch (error) {
    console.error('An error occurred while fetching data: ', error);
  }
};
// getHabitCalendar
export const getHabitCalendar = async (year: string, month: string) => {
  try {
    const response = await axios.get(`${REACT_APP_URL}${HABITS}/${habitId}/calendar?year=${year}&month=${month}`);
    return response.data;
  } catch (error) {
    console.error('An error occurred while fetching data: ', error);
  }
};
// getHabitToday
export const getHabitToday = async () => {
  try {
    const response = await axios.get(`${REACT_APP_URL}${HABITS}/today`);
    return response.data;
  } catch (error) {
    console.error('An error occurred while fetching data: ', error);
  }
};

// postSavingToday
export const postSavingToday = async () => {
  try {
    const response = await axios.post(`${REACT_APP_URL}${HABITS}/today`, {
      habitList: {
        habitId: '111111111111122112334', // 여기 타입 Long임.
      },
    });
    return response.data;
  } catch (error) {
    console.error('An error occurred while fetching data: ', error);
  }
};
