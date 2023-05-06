import { Affix, Layout, Menu } from 'antd';
import { HomeOutlined, AppstoreOutlined, UserOutlined, InfoCircleOutlined, ReadOutlined } from '@ant-design/icons';
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
} from "react-router-dom";
import AboutPage from '../pages/AboutPage';
import CoursePage from '../pages/course-pages/CoursePage';
import LecturePage from '../pages/course-pages/LecturePage';
import '../css/App.css'
import CoursesPage from '../pages/CoursesPage';
import ModulePage from '../pages/course-pages/ModulePage';
import TestPage from '../pages/course-pages/TestPage';
import StudentProfile from '../pages/StudentProfile';
import HomePage from '../pages/HomePage';
import LoginPage from '../pages/LoginPage';


const { Header } = Layout;

const NavBar = () => {
  return (
    <Router>
      <Affix>
        <Header>
          <div className="logo" />
          <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']}>
            <Menu.Item key="1" icon={<HomeOutlined />}>
              <Link to="/">
                Главная
              </Link>
            </Menu.Item>
            <Menu.Item key="2" icon={<AppstoreOutlined />}>
              <Link to="/courses">
                Курсы
              </Link>
            </Menu.Item>
            <Menu.Item key="3" icon={<ReadOutlined />}>
              <Link to="/forum">
                Форум
              </Link>
            </Menu.Item>
            <Menu.Item key="4"  style={{ marginLeft: "auto" }} icon={<UserOutlined/>} >
              <Link to="/profile/student">
                Личный кабинет
              </Link>
            </Menu.Item>
            <Menu.Item key="5" icon={<InfoCircleOutlined />}>
              <Link to="/about">
                О нас
              </Link>
            </Menu.Item>
          </Menu>
        </Header>
      </Affix>

      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/courses" element={<CoursesPage />} />
        <Route path="/about" element={<AboutPage />} />
        <Route path="/courses/:id" element={<CoursePage />} />
        <Route path="/courses/:id/lectures/:id" element={<LecturePage />} />
        <Route path="/courses/:id/modules" element={<ModulePage />} />
        <Route path="/courses/:id/modules/:id/test" element={<TestPage />} />
        <Route path="/profile/student" element={<StudentProfile />} />
      </Routes>
    </Router>
  );
};

export default NavBar;