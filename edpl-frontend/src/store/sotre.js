import { createStore } from 'redux';
import rootReducer from './reducers'; // Ваш корневой редюсер

const store = createStore(rootReducer);